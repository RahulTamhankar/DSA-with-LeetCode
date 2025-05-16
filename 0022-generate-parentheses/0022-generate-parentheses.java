class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> output = new ArrayList<>();
        generate(output, "", n, n);
        return output;
    }

    private void generate(ArrayList<String> output, String op, int o, int c) {
        if (o == 0 && c == 0) {
            output.add(op);
            return;
        }

        if (o > 0) {
            generate(output, op + "(", o - 1, c);
        }

        if (c > o) {
            generate(output, op + ")", o, c - 1);
        }
    }
}
