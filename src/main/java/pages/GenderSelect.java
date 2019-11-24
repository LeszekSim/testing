package pages;

public enum GenderSelect {

    Male,
    Female;


    public String toString() {
        switch (this) {
            case Male:
                return "1";
            case Female: return "2";
        }
        return this.toString();
    }



}
