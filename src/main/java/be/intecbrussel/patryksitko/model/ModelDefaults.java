package be.intecbrussel.patryksitko.model;

public interface ModelDefaults<PK, OBJ> {

    public abstract PK getPrimaryKey();

    public abstract void update(OBJ updated);
}