package dao.Entity;

public enum EmployType {
    CAISSIER,
    LIVREUR;

    public EmployType getEmployType(String employeeType) {
        switch (employeeType.trim().toLowerCase()) {
            case "caissier":
                return EmployType.CAISSIER;
            case "livreur":
                return EmployType.LIVREUR;
            default: return null;
        }
    }
}
