package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");

        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");

        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");

        registry.registerLandscapeBannerTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerGlossBannerTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerGlossBannerImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerScrimBannerTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerScrimBannerImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerMeshBannerTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerMeshBannerImageApertureAdder("PrintableProduct", "addAperture");

        registry.registerLandscapeBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerLandscapeBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerPortraitBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerPortraitBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerIvoryBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerIvoryBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerGrayBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerGrayBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerWhiteBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerWhiteBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerLaidBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerLaidBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerLinenBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerLinenBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerSmoothBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerSmoothBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerSingleSidedBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerSingleSidedBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
        registry.registerDoubleSidedBusinessCardTextApertureAdder("PrintableProduct", "addAperture");
        registry.registerDoubleSidedBusinessCardImageApertureAdder("PrintableProduct", "addAperture");
    }
}
