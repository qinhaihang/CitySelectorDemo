package com.qinhaihang.cityselectordemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qinhaihang.cityselectordemo.Utils.NetUtils;
import com.qinhaihang.cityselectordemo.bean.AddrBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CitySelectActivity extends AppCompatActivity implements NetUtils.OnReqeustCallback, AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "CitySelectActivity";
    @BindView(R.id.lv_city)
    ListView lv_city;

    @BindView(R.id.rb_province)
    RadioButton rb_province;

    @BindView(R.id.rb_city)
    RadioButton rb_city;

    @BindView(R.id.rb_county)
    RadioButton rb_county;

    @BindView(R.id.rb_town)
    RadioButton rb_town;

    @BindView(R.id.rb_selector)
    RadioButton rb_selector;

    @BindView(R.id.rg_addr)
    RadioGroup rg_addr;

    private String mUuid = "K1512241439001";
    private List<AddrBean> provinceList = new ArrayList<>();
    private List<AddrBean> cityList = new ArrayList<>();
    private List<AddrBean> countyList = new ArrayList<>();
    private List<AddrBean> townList = new ArrayList<>();
    private List<AddrBean> villageList = new ArrayList<>();
    private List<AddrBean> currentList = new ArrayList<>();

    private int mCurrentLev = 0;
    private AddrAdapter mAddrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);
        ButterKnife.bind(this);

        mAddrAdapter = new AddrAdapter(this,currentList);
        lv_city.setAdapter(mAddrAdapter);
        lv_city.setOnItemClickListener(this);

        mCurrentLev = 1;
        NetUtils.requestAddr(mUuid,"",mCurrentLev,this);

        rg_addr.setOnCheckedChangeListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,R.anim.city_out_anim);
    }

    @OnClick({R.id.rl_top , R.id.iv_close})
    public void back(View view){
        finish();
        overridePendingTransition(0,R.anim.city_out_anim);
    }



    @Override
    public void onSuccess(Object result, int id) {

        ArrayList<AddrBean> tempList = (ArrayList<AddrBean>) result;
        currentList.clear();
        currentList.addAll(tempList);

        mAddrAdapter.notifyDataSetChanged();

        switch (mCurrentLev){
            case 1:
                provinceList.clear();
                provinceList.addAll(tempList);
                break;
            case 2:
                cityList.clear();
                cityList.addAll(tempList);
                break;
            case 3:
                countyList.clear();
                countyList.addAll(tempList);
                break;
            case 4:
                townList.clear();
                townList.addAll(tempList);
                break;
            case 5:
                villageList.clear();
                villageList.addAll(tempList);
                break;
        }
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        AddrBean addrBean = currentList.get(position);
        String cityId = addrBean.getCityId();

        switch (mCurrentLev){
            case 1: //标识选中的省
                setAddrSelected(provinceList,position);
                rb_province.setVisibility(View.VISIBLE);
                rb_province.setText(addrBean.getCityName());
                rb_city.setVisibility(View.GONE);
                rb_county.setVisibility(View.GONE);
                rb_town.setVisibility(View.GONE);
                rb_selector.setText("请选择");
                rb_selector.setChecked(true);
                break;
            case 2:
                setAddrSelected(cityList,position);
                rb_city.setVisibility(View.VISIBLE);
                rb_city.setText(addrBean.getCityName());
                rb_county.setVisibility(View.GONE);
                rb_town.setVisibility(View.GONE);
                rb_selector.setText("请选择");
                rb_selector.setChecked(true);
                break;
            case 3:
                setAddrSelected(countyList,position);
                rb_county.setVisibility(View.VISIBLE);
                rb_county.setText(addrBean.getCityName());
                rb_town.setVisibility(View.GONE);
                rb_selector.setText("请选择");
                rb_selector.setChecked(true);
                break;
            case 4:
                setAddrSelected(townList,position);
                rb_town.setVisibility(View.VISIBLE);
                rb_town.setText(addrBean.getCityName());
                rb_selector.setText("请选择");
                rb_selector.setChecked(true);
                break;
            case 5:
                setAddrSelected(villageList,position);
                rb_selector.setText(addrBean.getCityName());
                break;
        }

        mCurrentLev++;
        if(mCurrentLev < 6){
            NetUtils.requestAddr(mUuid,cityId,mCurrentLev,this);
        } else {
            setAddrSelected(villageList,position);
            currentList.clear();
            currentList.addAll(villageList);
            mAddrAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


    }

    @OnClick({R.id.rb_province,R.id.rb_city,R.id.rb_county,R.id.rb_town,R.id.rb_selector})
    public void rb_click(View view){

        switch (view.getId()){
            case R.id.rb_province:
                mCurrentLev = 1;
                currentList.clear();
                currentList.addAll(provinceList);
                break;

            case R.id.rb_city:
                mCurrentLev = 2;
                currentList.clear();
                currentList.addAll(cityList);
                break;

            case R.id.rb_county:
                mCurrentLev = 3;
                currentList.clear();
                currentList.addAll(countyList);
                break;

            case R.id.rb_town:
                mCurrentLev = 4;
                currentList.clear();
                currentList.addAll(townList);
                break;

            case R.id.rb_selector:
                mCurrentLev = 5;
                currentList.clear();
                currentList.addAll(villageList);
                break;
        }

        mAddrAdapter.notifyDataSetChanged();
    }

    public class AddrAdapter extends BaseAdapter{

        private Context mContext;
        private List<AddrBean> list;

        public AddrAdapter(Context context, List<AddrBean> list) {
            mContext = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            AddrBean addrBean = list.get(position);
            AddrHolder holder = null;

            if(convertView == null){

                convertView = View.inflate(mContext,R.layout.addr_item_layout,null);
                holder = new AddrHolder(convertView);

                convertView.setTag(holder);

            }else{
                holder = (AddrHolder) convertView.getTag();
            }

            holder.tv_addr.setText(addrBean.getCityName());

            holder.tv_addr.setTextColor(!"1".equals(addrBean.getIsSelector()) ? mContext.getResources().getColor(R.color.Black) : mContext.getResources().getColor(R.color.Red));

            return convertView;
        }
    }

    class AddrHolder{

        @BindView(R.id.tv_addr)
        public TextView tv_addr;

        public AddrHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }

    /**
     * 标志选中的item
     * @param list
     * @param position
     */
    private void setAddrSelected(List<AddrBean> list,int position){

        for (AddrBean addrBean : list){
            addrBean.setIsSelector("0");
        }

        list.get(position).setIsSelector("1");

    }

}
