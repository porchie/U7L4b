public class Address {
    private String streetNum;
    private String streetName;
    private String aptNum;
    private String city;
    private String state;
    private int zip;


    public Address(String address)
    {
        boolean hasApt = true;
        if(address.indexOf("Apt") == -1)
        {
            hasApt = false;
            aptNum = "-1";
        }
        streetNum = address.substring(0,address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        if(hasApt)
        {
            streetName = address.substring(0,address.indexOf("Apt") -1);
            address = address.substring(address.indexOf("Apt"));
            aptNum = address.substring(0,address.indexOf(","));
            address = address.substring(address.indexOf(",") + 2);
        }
        else
        {
            streetName = address.substring(0,address.indexOf(","));
            address = address.substring(address.indexOf(",") + 2);
        }

        city = address.substring(0,address.indexOf(","));
        address = address.substring(address.indexOf(",") + 2);
        state = address.substring(0,address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        zip = Integer.parseInt(address);
    }

    public Address(Address address)
    {
        copyAddress(address);
    }

    public Address(String streetNum, String streetName, String aptNum, String city, String state, int zip)
    {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.aptNum = aptNum;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }





    private void copyAddress(Address address)
    {
        streetNum = address.getStreetNum();
        streetName = address.getStreetName();
        aptNum = address.getAptNum();
        city = address.getCity();
        state = address.getState();
        zip = address.getZip();
    }

    public String toString()
    {
        String str = "";
        str += streetNum;
        str += streetName;
        str += (!aptNum.equals("-1"))  ? aptNum:"";
        str += ", " + city;
        str += ", " + state;
        str += zip;
        return str;
    }


    public boolean isSame(Address address)
    {
        return (streetNum.equals(address.getStreetNum())&&
        streetName.equals(address.getStreetName())||
        aptNum.equals(address.getAptNum())&&
        city.equals(address.getCity())&&
        state.equals(address.getState())&&
        zip == address.getZip());
    }







    public int getZip() {
        return zip;
    }


    public String getState() {
        return state;
    }


    public String getCity() {
        return city;
    }



    public String getStreetName() {
        return streetName;
    }


    public String getAptNum() {
        return aptNum;
    }


    public String getStreetNum() {
        return streetNum;
    }


}
