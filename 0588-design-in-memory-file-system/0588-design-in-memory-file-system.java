class FileSystem {

    private class Node {
        private String name;
        private boolean isFile = false;
        private StringBuilder content;
        private TreeMap<String, Node> children;

        public Node(String name) {
            this.name = name;
            this.content = new StringBuilder();
            this.children = new TreeMap<>();
        }

        public Node(String name, boolean isFile) {
            this.name = name;
            this.content = new StringBuilder();
            this.isFile = isFile;
            this.children = new TreeMap<>();
        }

        public void appendContent(String content) {
            this.content.append(content);
        }

        public String readContent() {
            return this.content.toString();
        }
    }

    private Node rootNode;

    public FileSystem() {
        rootNode = new Node("");
    }

    public List<String> ls(String path) {
        List<String> resultList = new ArrayList<>();
        String[] files = path.split("/");
        int len = files.length;
        Node curr = rootNode;

        for (int i = 1; i < len; i++) {
            curr = curr.children.get(files[i]);
        }

        if (curr.isFile) {
            resultList.add(curr.name);
        } else {
            resultList.addAll(curr.children.keySet());
        }

        return resultList;
    }

    public void mkdir(String path) {
        String[] dirs = path.split("/");
        Node curr = rootNode;

        for (String dir : dirs) {
            if (dir.isEmpty()) continue;
            curr.children.putIfAbsent(dir, new Node(dir, false));
            curr = curr.children.get(dir);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] files = filePath.split("/");
        int len = files.length;
        Node curr = rootNode;

        for (int i = 1; i < len - 1; i++) {
            curr = curr.children.get(files[i]);
        }

        String fileName = files[len - 1];
        if (!curr.children.containsKey(fileName)) {
            curr.children.put(fileName, new Node(fileName, true));
        }

        curr.children.get(fileName).appendContent(content);
    }

    public String readContentFromFile(String filePath) {
        String[] files = filePath.split("/");
        Node curr = rootNode;

        for (int i = 1; i < files.length; i++) {
            curr = curr.children.get(files[i]);
        }

        return curr.readContent();
    }
}
