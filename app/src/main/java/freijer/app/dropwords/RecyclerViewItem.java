package freijer.app.dropwords;

public class RecyclerViewItem {

    private int imageResource;
    private String text_1;

    public int getImageResource() {
        return imageResource;
    }
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
        public String getText_1() {
            return text_1;
        }
        public void setText_1(String text_1) {
            this.text_1 = text_1;
        }


    public RecyclerViewItem(int imageResource, String text_1) {
        this.imageResource = imageResource;
        this.text_1 = text_1;
    }


}
