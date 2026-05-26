class SqueakyClean {
    static String clean(String identifier) {
        identifier = identifier
                .replace(' ', '_')
                .replace('4', 'a')
                .replace('3', 'e')
                .replace('0', 'o')
                .replace('1', 'l')
                .replace('7', 't');

        StringBuilder s = new StringBuilder();
        boolean dashSpotted = false;

        for (char ch : identifier.toCharArray()) {
            if (ch == '-') {
                dashSpotted = true;
                continue;
            }

            if (ch != '_' && !Character.isLetter(ch)) {
                continue;
            }

            s.append(dashSpotted ? Character.toUpperCase(ch) : ch);
            dashSpotted = false;
        }

        return s.toString();
    }
}
