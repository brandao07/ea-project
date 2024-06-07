package eaproject.input;

public abstract class BaseInput {
    private boolean lazyLoad;

    public BaseInput() {
        this.lazyLoad = false;
    }

    public boolean isLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(boolean lazyLoad) {
        this.lazyLoad = lazyLoad;
    }
}
