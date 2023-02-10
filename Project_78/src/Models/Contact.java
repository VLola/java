package Models;

public class Contact {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    protected FullName FullName;
    protected Phone Phone;
    protected Category Category;

    public Models.Phone getPhone() {
        return Phone;
    }

    public Models.FullName getFullName() {
        return FullName;
    }

    public Models.Category getCategory() {
        return Category;
    }

    public void setFullName(Models.FullName fullName) {
        FullName = fullName;
    }

    public void setCategory(Models.Category category) {
        Category = category;
    }

    public void setPhone(Models.Phone phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Full Name: " + ANSI_CYAN + FullName.getSurname() + " " + FullName.getName() + " " + FullName.getPatronymic() + ANSI_RESET + " Phone: " + ANSI_CYAN + Phone.getNumber() + ANSI_RESET + " Category: " + ANSI_CYAN + Category.getName() + ANSI_RESET;
    }
}
