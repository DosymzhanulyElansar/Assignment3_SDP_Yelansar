public class Main {
    public static void main(String[] args) {
        int passed = 0;
        int total = 7;

        Reminder r1 = new Reminder("N1", "Meeting at 3 PM", new EmailChannel());
        String resT1 = r1.execute();
        boolean passT1 = resT1.equals("[Email Envelope] Reminder: Meeting at 3 PM");
        printCheck("T1", passT1, "Reminder + EmailChannel", resT1, "[Email Envelope] Reminder: Meeting at 3 PM");
        if (passT1) passed++;

        Reminder r2 = new Reminder("N1", "Meeting at 3 PM", new SmsChannel());
        String resT2 = r2.execute();
        boolean passT2 = resT2.equals("[SMS] Reminder: Meeting at 3 PM");
        printCheck("T2", passT2, "Reminder + SmsChannel", resT2, "[SMS] Reminder: Meeting at 3 PM");
        if (passT2) passed++;

        UrgentAlert u1 = new UrgentAlert("N2", "Server Down", new EmailChannel());
        String resT3 = u1.execute();
        boolean passT3 = resT3.equals("[Email Envelope] URGENT: Server Down");
        printCheck("T3", passT3, "UrgentAlert + EmailChannel", resT3, "[Email Envelope] URGENT: Server Down");
        if (passT3) passed++;

        UrgentAlert u2 = new UrgentAlert("N2", "Server Down", new SmsChannel());
        String resT4 = u2.execute();
        boolean passT4 = resT4.equals("[SMS] URGENT: Server Down");
        printCheck("T4", passT4, "UrgentAlert + SmsChannel", resT4, "[SMS] URGENT: Server Down");
        if (passT4) passed++;

        Reminder t5Obj = new Reminder("N3", "Pay bills", new EmailChannel());
        String before = t5Obj.execute();
        Reminder refBefore = t5Obj;

        t5Obj.setImplementation(new SmsChannel());
        String after = t5Obj.execute();
        Reminder refAfter = t5Obj;

        boolean sameObject = (refBefore == refAfter);
        boolean stateUnchanged = t5Obj.getId().equals("N3") && t5Obj.getMessage().equals("Pay bills");
        boolean passT5 = sameObject && stateUnchanged && before.equals("[Email Envelope] Reminder: Pay bills") && after.equals("[SMS] Reminder: Pay bills");

        System.out.printf("T5 %s sameObject=%b | stateUnchanged=%b\n  before=%s | after=%s\n",
                passT5 ? "PASS" : "FAIL", sameObject, stateUnchanged, before, after);
        if (passT5) passed++;

        Reminder r3 = new Reminder("N1", "Meeting at 3 PM", new PushChannel());
        String resT6 = r3.execute();
        boolean passT6 = resT6.equals("[Push Notification] Reminder: Meeting at 3 PM");
        printCheck("T6", passT6, "Reminder + PushChannel", resT6, "[Push Notification] Reminder: Meeting at 3 PM");
        if (passT6) passed++;

        UrgentAlert u3 = new UrgentAlert("N2", "Server Down", new PushChannel());
        String resT7 = u3.execute();
        boolean passT7 = resT7.equals("[Push Notification] URGENT: Server Down");
        printCheck("T7", passT7, "UrgentAlert + PushChannel", resT7, "[Push Notification] URGENT: Server Down");
        if (passT7) passed++;

        System.out.printf("SUMMARY: %d/%d PASS\n", passed, total);
    }

    private static void printCheck(String id, boolean pass, String details, String actual, String expected) {
        if (pass) {
            System.out.printf("%s PASS | %s | result=%s\n", id, details, actual);
        } else {
            System.out.printf("%s FAIL | %s | expected=%s | actual=%s\n", id, details, expected, actual);
        }
    }
}
