package api.DHFile.enums;

public enum RoleEnum {
    ADMIN("ADMIN"),
    USER("USER");
    
    private RoleEnum(String label) {
        this.label=label;
    }
    public final String label;

    public String getLabel(){
        return label;
    }
}