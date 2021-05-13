package academy.pocu.comp2500.assignment2;

public class Banner extends PrintableProduct {
    final private BannerType bannerType;
    final private BannerSize bannerSize;

    public Banner(Color color, BannerType bannerType, BannerSize bannerSize, Orientation orientation) {
        super(createName(bannerType, bannerSize), color, createSize(bannerSize, orientation), createPrice(bannerSize, bannerType), orientation);

        this.bannerType = bannerType;
        this.bannerSize = bannerSize;
    }

    public BannerType getBannerType() {
        return this.bannerType;
    }

    public BannerSize getBannerSize() {
        return this.bannerSize;
    }

    private static String createName(BannerType bannerType, BannerSize bannerSize) {
        String name = null;
        switch (bannerType) {
            case GLOSS:
                switch (bannerSize) {
                    case SIZE_1000X500:
                        name = "Gloss Banner (1000mm x 500mm)";
                        break;
                    case SIZE_1000X1000:
                        name = "Gloss Banner (1000mm x 1000mm)";
                        break;
                    case SIZE_2000X500:
                        name = "Gloss Banner (2000mm x 500mm)";
                        break;
                    case SIZE_3000X1000:
                        name = "Gloss Banner (3000mm x 1000mm)";
                        break;
                    default:
                        break;
                }
                break;
            case MESH:
                switch (bannerSize) {
                    case SIZE_1000X500:
                        name = "Mesh Banner (1000mm x 500mm)";
                        break;
                    case SIZE_1000X1000:
                        name = "Mesh Banner (1000mm x 1000mm)";
                        break;
                    case SIZE_2000X500:
                        name = "Mesh Banner (2000mm x 500mm)";
                        break;
                    case SIZE_3000X1000:
                        name = "Mesh Banner (3000mm x 1000mm)";
                        break;
                    default:
                        break;
                }
                break;
            case SCRIM:
                switch (bannerSize) {
                    case SIZE_1000X500:
                        name = "Scrim Banner (1000mm x 500mm)";
                        break;
                    case SIZE_1000X1000:
                        name = "Scrim Banner (1000mm x 1000mm)";
                        break;
                    case SIZE_2000X500:
                        name = "Scrim Banner (2000mm x 500mm)";
                        break;
                    case SIZE_3000X1000:
                        name = "Scrim Banner (3000mm x 1000mm)";
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        return name;
    }

    private static Size createSize(BannerSize bannerSize, Orientation bannerOrientation) {
        Size size = null;

        switch (bannerOrientation) {
            case PORTRAIT:
                switch (bannerSize) {
                    case SIZE_1000X500:
                        size = new Size(500, 1000);
                        break;
                    case SIZE_1000X1000:
                        size = new Size(1000, 1000);
                        break;
                    case SIZE_2000X500:
                        size = new Size(500, 2000);
                        break;
                    case SIZE_3000X1000:
                        size = new Size(1000, 3000);
                        break;
                    default:
                        break;
                }
                break;
            case LANDSCAPE:
                switch (bannerSize) {
                    case SIZE_1000X500:
                        size = new Size(1000, 500);
                        break;
                    case SIZE_1000X1000:
                        size = new Size(1000, 1000);
                        break;
                    case SIZE_2000X500:
                        size = new Size(2000, 500);
                        break;
                    case SIZE_3000X1000:
                        size = new Size(3000, 1000);
                        break;
                    default:
                        break;
                }
                break;
        }

        return size;
    }

    private static int createPrice(BannerSize bannerSize, BannerType bannerType) {
        int price = 0;

        switch (bannerType) {
            case GLOSS:
                switch (bannerSize) {
                    case SIZE_1000X500:
                        price = 5000;
                        break;
                    case SIZE_1000X1000:
                        price = 5200;
                        break;
                    case SIZE_2000X500:
                        price = 5300;
                        break;
                    case SIZE_3000X1000:
                        price = 6000;
                        break;
                    default:
                        break;
                }
                break;
            case SCRIM:
            case MESH:
                switch (bannerSize) {
                    case SIZE_1000X500:
                        price = 5100;
                        break;
                    case SIZE_1000X1000:
                        price = 5300;
                        break;
                    case SIZE_2000X500:
                        price = 5400;
                        break;
                    case SIZE_3000X1000:
                        price = 6100;
                        break;
                    default:
                        break;
                }
        }

        return price;
    }
}
