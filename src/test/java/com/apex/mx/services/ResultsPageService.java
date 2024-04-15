package com.apex.mx.services;

public abstract class ResultsPageService {
    public abstract boolean isVisibleArticlesResults();

    public abstract boolean allArticlesNamesContains(String nameProduct);

    public abstract boolean isvisibleNoArticleNotification(String productName);

    public abstract boolean doesTheResultContainsWords(String productName);
}
