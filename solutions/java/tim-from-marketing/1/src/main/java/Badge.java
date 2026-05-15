class Badge {
    public String print(Integer id, String name, String department) {
        String _id = id == null ? "" : ("[" + Integer.toString(id) + "] - ");
        department = department == null ? "owner" : department;

        return String.format("%s%s - %s", _id, name, department.toUpperCase());
    }
}
