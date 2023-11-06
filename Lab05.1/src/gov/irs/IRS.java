package gov.irs;

public interface IRS { // this allows for the encapsulation of the IRSEnum behind the
                        // IRS interface.

    //Implementation methods
    public void collectTaxes();
    public void register(TaxPayer payer);

    //static factory method to obtain the instance
    public static IRS getInstance(){
        return IRSEnum.INSTANCE;
    }
}