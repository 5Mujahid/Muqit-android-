package com.example.muqitt.DataManager;

import com.example.muqitt.Interface.DataManager;
import com.example.muqitt.Interface.OnDataLoadListener;
import com.example.muqitt.Retrofit.RetrofitUtil;
import com.example.muqitt.Utils.DatabaseUtil;

import static com.example.muqitt.Retrofit.RetrofitUtil.getCategries;

/**
 * Created by Gohar Ali on 12/25/2017.
 */

public class CategoryDataManager implements DataManager {

    @Override
    public void loadDataFromServer(OnDataLoadListener listener, boolean isForced) {
        if(isForced) {
            RetrofitUtil.createProviderAPI().loadCategories().enqueue(getCategries(listener));
        }else{
            loadDataFromDataBase(listener);
        }
    }

    @Override
    public void loadDataFromDataBase(OnDataLoadListener listener) {
        listener.onCategoriesLoad(DatabaseUtil.getInstance().getCategoriesList());
    }

    @Override
    public void saveDataToDataBase(Object data) {
       // DatabaseUtil.getInstance().delteCategoriesList();
       // DatabaseUtil.getInstance().storeCategoriesList((List<Category>)(Object)data);
    }

    @Override
    public void deleteDataToDataBase() {
        DatabaseUtil.getInstance().delteCategoriesList();
    }
}
