package object;

public class Bill {
    private String bill_id;
    private String acc_id;
    private String date;
    private String time;
    private String product_id;
    private int participants;
    private String message;
    private int quantity;

    public Bill() {
        this.bill_id = "";
        this.acc_id = "";
        this.date = "";
        this.time = "";
        this.product_id = "";
        this.participants = 0;
        this.message = "";
        this.quantity = 0;
    }
    
    public Bill(String acc_id, String date, String time, String product_id, int participants, String message, int quantity) {
        this.bill_id = generateAutoCode(acc_id, date);
        this.acc_id = acc_id;
        this.date = date;
        this.time = time;
        this.product_id = product_id;
        this.participants = participants;
        this.message = message;
        this.quantity = quantity;
    }
    
    private String generateAutoCode(String id, String date) {
        String lastThreeDigits = id.length() > 3 ? id.substring(id.length() - 3) : id;
        String formattedDate = date.length() > 2 ? date.substring(id.length() - 2) : date;
        return lastThreeDigits + formattedDate;
    }
    
    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Bill{" +
                "bill_id=" + bill_id +
                ", acc_id='" + acc_id + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", product_id=" + product_id +
                ", participants=" + participants +
                ", message='" + message + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
