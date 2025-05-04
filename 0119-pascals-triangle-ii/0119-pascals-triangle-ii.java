class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 0) return new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i <= numRows; i++) {  // Fix: use <= to include numRows-th row
            List<Integer> prevRow = result.get(i - 1);

            List<Integer> row = new ArrayList<>();
            row.add(1);  // First element is always 1

            for (int j = 1; j < prevRow.size(); j++) {  // Fix: correct range and logic
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);  // Last element is always 1
            result.add(row);
        }

        return result.get(numRows);
    }
}
