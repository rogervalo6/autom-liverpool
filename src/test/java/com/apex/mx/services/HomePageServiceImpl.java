package com.apex.mx.services;

import com.apex.mx.pages.HomepagePO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HomePageServiceImpl extends HomePageService {

    private final static Logger logger = LoggerFactory.getLogger(HomePageServiceImpl.class);


    private HomepagePO homepage;

    @Override
    public void addTextToSearchField(String article) {
        homepage = new HomepagePO();
        homepage.getSearchField().sendKeys(article);
    }

    @Override
    public void clickOnSearchButton() {
        homepage = new HomepagePO();
        homepage.getSearchButton().click();
    }
}
