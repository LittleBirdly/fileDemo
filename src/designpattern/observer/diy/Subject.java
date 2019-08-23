package designpattern.observer.diy;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject implements SubjectInterface{

    protected boolean changed = false;
    protected List<ObInterface> obList;

    public Subject() {
        obList = new ArrayList<ObInterface>();
    }

    protected boolean isExistsObserver(ObInterface o) {

        return obList.contains(o);
    }

    protected boolean isChanged() {

        return changed;
    }

    protected void setChanged() {
        changed = true;
    }

    protected void clearChanged() {
        changed = false;
    }

    public void registObserver(ObInterface o) {
        if(!isExistsObserver(o))
            obList.add(o);
    }

    public void removeObserver(ObInterface o) {
        if(isExistsObserver(o))
            obList.remove(o);
    }

    public abstract void notifyObservers();

}
