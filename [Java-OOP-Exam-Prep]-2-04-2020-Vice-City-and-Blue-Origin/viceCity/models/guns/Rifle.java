package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, 500);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
            reload();
        }

        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 5);
        }

        return 5;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        setBulletsPerBarrel(BULLETS_PER_BARREL);
    }
}
