package game.item;

public final class ItemCreationException extends RuntimeException{

    public ItemCreationException(String msg){
        super(msg);
    }
    public ItemCreationException(String msg, Throwable cause){
        super(msg, cause);
    }

}
