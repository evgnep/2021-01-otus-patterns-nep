package su.nepom.patterns.home1.model;

/**
 * Интерфейс объекта, скоростью поворота которого можно управлять
 */
public interface RotatableManage extends Rotatable {
    void setAngleVelocity(int speed);
}
