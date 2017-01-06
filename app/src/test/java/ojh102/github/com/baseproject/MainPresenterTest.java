package ojh102.github.com.baseproject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ojh102.github.com.baseproject.common.APIService;
import ojh102.github.com.baseproject.main.adapter.MainAdapterModel;
import ojh102.github.com.baseproject.main.adapter.MainAdapterView;
import ojh102.github.com.baseproject.main.presenter.MainContract;
import ojh102.github.com.baseproject.main.presenter.MainPresenter;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by ohjaehwan on 2017. 1. 5..
 */

public class MainPresenterTest {
    @Mock
    private MainContract.View mainView;

    @Mock
    private APIService apiService;

    @Mock
    private MainAdapterModel mainAdapterModel;

    @Mock
    private MainAdapterView mainAdapterView;

    private MainPresenter mainPresenter;

    @Before
    public void setupMainPeresenter() {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(mainView, apiService, mainAdapterModel, mainAdapterView);
    }

    @Test
    public void searchImage_EmptyKeywordShowToast() {
        mainPresenter.searchImage("", 1);
        verify(mainView).showToast(anyString());
    }
}
