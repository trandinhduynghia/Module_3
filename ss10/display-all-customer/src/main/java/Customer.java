public class Customer {
    private String name;
    private String pictureLink;
    private String address;
    private String birthday;

    public Customer(){

    }

    public Customer(String name, String birthday, String address, String pictureLink){
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.pictureLink = pictureLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
