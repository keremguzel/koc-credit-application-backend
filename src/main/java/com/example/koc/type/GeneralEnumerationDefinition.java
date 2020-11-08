package com.example.koc.type;

public class GeneralEnumerationDefinition {
    public enum PageTypes {
        HOME_PAGE(1),
        PROD_DETAIL_PAGE(2),
        SEARCH_PAGE(3),
        OTHER_PAGES(4);

        private final Integer pageTypeCode;

        PageTypes(Integer pageTypeCode) {
            this.pageTypeCode = pageTypeCode;
        }

        public Integer getPageTypeCode() {
            return pageTypeCode;
        }
    }
}