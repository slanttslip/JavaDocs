package ro.teamnet.zerotohero.oop;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public final class immutable {
    private final int iv;
    private final String ivName;

    public immutable (int iv, String ivName) {
        this.iv=iv;
        this.ivName=ivName;

        ivName = new String(ivName);
    }


    public String getName() {
        return ivName;
    }
    public int ivint() {
        return iv;
    }

}
