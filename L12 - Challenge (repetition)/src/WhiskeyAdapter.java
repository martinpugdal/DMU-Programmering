public class WhiskeyAdapter extends Whiskey {

    private final Whisky whisky;

    public WhiskeyAdapter(Whisky whisky) {
        super(whisky.getName(), whisky.getOrigin(), whisky.getColor(), whisky.getAlcohol());
        this.whisky = whisky;
    }

    public Whiskey getWhisky() {
        return new Whiskey(whisky.getName(), whisky.getOrigin(), whisky.getColor(), whisky.getAlcohol());
    }
}
