public class exp2a1 { 
    static class AdsAccount { 
        private String accountId; 
        private String campaignName; 
        public AdsAccount(String accountId, String campaignName) { 
            this.accountId = accountId;
            this.campaignName = campaignName; 
        } 
        public String getAccountId() { 
            return accountId; 
        } 
        public String getCampaignName() { 
            return campaignName; 
        } 
    } 
    static class CampaignManager { 
        public void startCampaign(AdsAccount account) { 
            System.out.println("Starting campaign for account: " + account.getAccountId()); 
            System.out.println("Campaign Name: " + account.getCampaignName()); 
        } 
    } 
    static class CampaignAnalytics { 
        public void calculateCampaignStats(AdsAccount account) { 
            System.out.println("\nCalculating stats for campaign: " + account.getCampaignName()); 
            System.out.println("Stats..."); 
        } 
    } 
    static class AdsAccountRepository { 
        public void save(AdsAccount account) { 
            System.out.println("\nSaving AdsAccount to database:"); 
            System.out.println("Account ID: " + account.getAccountId()); 
            System.out.println("Campaign Name: " + account.getCampaignName()); 
        } 
    } 
    public static void main(String[] args) { 
        AdsAccount account = new AdsAccount("smk1106", "Dark Void Smeargle");
        CampaignManager campaignManager = new CampaignManager(); 
        CampaignAnalytics analytics = new CampaignAnalytics(); 
        AdsAccountRepository repository = new AdsAccountRepository(); 
        campaignManager.startCampaign(account); 
        analytics.calculateCampaignStats(account); 
        repository.save(account); 
    } 
} 