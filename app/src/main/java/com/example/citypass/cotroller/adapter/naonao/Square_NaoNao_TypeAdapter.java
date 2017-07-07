package com.example.citypass.cotroller.adapter.naonao;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.naonao.detail.DetailImageActivity;
import com.example.citypass.cotroller.fragment.naonao.detail.SquareDetailBean;
import com.example.citypass.cotroller.fragment.naonao.detail.SquareNaonaoDetailActivity;
import com.example.citypass.model.bean.naonao.Square_NaoNao_Bean;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/27 11:49
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class Square_NaoNao_TypeAdapter extends RecyclerView.Adapter {
    private List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList;
    private View view;
    private Context context;
    private Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean bean;
    private int onePosition, twoPostion, ThreePostion, FourPosition, FivePosition;
    private Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean oneBean;
    private mOnItemClickListener clickListener;


    public Square_NaoNao_TypeAdapter(List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        String image = mList.get(position).getImage();
        if (image == null) {
            return 0;
        }

        String[] split = image.split("\\|");

        if (split.length == 1) {
            return 1;
        } else if (split.length == 2) {
            return 2;
        } else if (split.length == 3) {
            return 3;
        } else if (split.length == 4) {
            return 4;
        } else if (split.length == 5) {
            return 5;
        } else if (split.length == 6) {
            return 5;
        } else if (split.length == 7) {
            return 5;
        } else if (split.length == 8) {
            return 5;
        } else if (split.length == 9) {
            return 5;
        }

        return split.length;
    }

    //加载布局文件
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.square_naonao_recycle_item, null);

                view.setLayoutParams(params);

                holder = new mViewHodlerOne(view);

                break;
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.square_naonao_recycle_item, null);

                view.setLayoutParams(params);

                holder = new mViewHodlerOne(view);

                break;
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.square_naonao_recycle_item2, null);
                view.setLayoutParams(params);
                holder = new mViewHodlerTwo(view);
                break;
            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.square_naonao_recycle_item3, null);
                view.setLayoutParams(params);
                holder = new mViewHodlerThree(view);
                break;
            case 4:
                view = LayoutInflater.from(context).inflate(R.layout.square_naonao_recycle_item4, null);
                view.setLayoutParams(params);
                holder = new mViewHodlerFour(view);
                break;
            case 5:
                view = LayoutInflater.from(context).inflate(R.layout.square_naonao_recycle_item5, null);
                view.setLayoutParams(params);
                holder = new mViewHodlerFive(view);
                break;
        }
        return holder;
    }

    //处理业务逻辑  //这个position是视图索引。。我需要的是每个点击事件得到position
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                mViewHodlerOne one = (mViewHodlerOne) holder;
                oneBind(one, position);

                break;
            case 1:
                mViewHodlerOne one1 = (mViewHodlerOne) holder;
                oneBind(one1, position);
                break;
            case 2:
                mViewHodlerTwo two = (mViewHodlerTwo) holder;
                twoBind(two, position);
                break;
            case 3:
                mViewHodlerThree three = (mViewHodlerThree) holder;
                threeBind(three, position);
                break;
            case 4:
                mViewHodlerFour four = (mViewHodlerFour) holder;
                FourBind(four, position);
                break;
            case 5:
                mViewHodlerFive five = (mViewHodlerFive) holder;

                FiveBind(five, position);

                break;

        }


    }


    // TODO: 2017/6/27 第一个子view
    private void oneBind(mViewHodlerOne holder, int position) {
        bean = mList.get(position);
        holder.mPinLun.setText(bean.getDing() + "");
        holder.mZan.setText(bean.getTchild() + "");
        holder.mAddress.setText(bean.getMapName() + "");
        holder.mBody.setText(bean.getTitle() + "");
        holder.mLevel.setText("lv." + bean.getLevel() + "");
        holder.mName.setText(bean.getNick() + "");
        holder.mTime.setText(bean.getLastTime() + "");
        final ImageView img = holder.mTouXiang;
        Glide.with(context).load(bean.getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                img.setImageDrawable(ciDrawable);
            }
        });

        if (bean.getReplyJson1() != null) {
            holder.mTextPinLunName.setText(bean.getReplyJson1().getNick() + " : ");
            holder.mTextPinLun.setText(bean.getReplyJson1().getContent() + "");
        } else {
            holder.mTextPinLun.setVisibility(View.GONE);
            holder.mTextPinLunName.setVisibility(View.GONE);
        }
        if (bean.getImage().equals("")) {
            holder.mOne.setVisibility(View.GONE);
            holder.mHodlerImage.setVisibility(View.GONE);
        } else {
            holder.mOne.setVisibility(View.VISIBLE);
            holder.mHodlerImage.setVisibility(View.VISIBLE);
            Glide.with(context).load(bean.getImage()).error(R.drawable.error).into(holder.mHodlerImage);
//            Picasso.with(context).load(this.bean.getImage()).error(R.drawable.location_icon).into(holder.mHodlerImage);
        }

    }

    // TODO: 2017/6/27   //第二个子view
    public void twoBind(mViewHodlerTwo holder, int position) {
        bean = mList.get(position);
        holder.mPinLun.setText(this.bean.getTchild() + "");
        holder.mZan.setText(this.bean.getDing() + "");
        holder.mAddress.setText(this.bean.getMapName() + "");
        holder.mBody.setText(this.bean.getTitle() + "");
        holder.mLevel.setText("lv." + this.bean.getLevel() + "");
        holder.mName.setText(this.bean.getNick() + "");
        holder.mTime.setText(this.bean.getLastTime() + "");
        final ImageView img = holder.mTouXiang;

        Glide.with(context).load(this.bean.getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                img.setImageDrawable(ciDrawable);
            }
        });

        if (this.bean.getReplyJson1() != null) {
            holder.mTextPinLunName.setText(this.bean.getReplyJson1().getNick() + " : ");
            holder.mTextPinLun.setText(this.bean.getReplyJson1().getContent() + "");
        } else {
            holder.mTextPinLun.setVisibility(View.GONE);
            holder.mTextPinLunName.setVisibility(View.GONE);
        }
        String[] split = mList.get(position).getImage().split("\\|");
        Log.d("Square_NaoNao_TypeAdapt", "split:" + split);

        if (split.length != 0) {
            Glide.with(context).load(split[0]).into(holder.HodlerImage1);
            Glide.with(context).load(split[1]).into(holder.HodlerImage2);
        }

    }

    // TODO: 2017/6/27   //第三个bind 子view
    public void threeBind(mViewHodlerThree holder, int position) {
        bean = mList.get(position);
        holder.mPinLun.setText(this.bean.getDing() + "");
        holder.mZan.setText(this.bean.getTchild() + "");
        holder.mAddress.setText(this.bean.getMapName() + "");
        holder.mBody.setText(this.bean.getTitle() + "");
        holder.mLevel.setText("lv." + this.bean.getLevel() + "");
        holder.mName.setText(this.bean.getNick() + "");
        holder.mTime.setText(this.bean.getLastTime() + "");
        final ImageView img = holder.mTouXiang;

        Glide.with(context).load(this.bean.getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                img.setImageDrawable(ciDrawable);
            }
        });

        if (this.bean.getReplyJson1() != null) {
            holder.mTextPinLunName.setText(this.bean.getReplyJson1().getNick() + " : ");
            holder.mTextPinLun.setText(this.bean.getReplyJson1().getContent() + "");
        } else {
            holder.mTextPinLun.setVisibility(View.GONE);
            holder.mTextPinLunName.setVisibility(View.GONE);
        }
        String[] split = mList.get(position).getImage().split("\\|");

        if (split.length != 0) {
            Glide.with(context).load(split[0]).into(holder.HodlerImage1);
            Glide.with(context).load(split[1]).into(holder.HodlerImage2);
            Glide.with(context).load(split[2]).into(holder.HodlerImage3);
        }

    }

    // TODO: 2017/6/27   //第四个bind 子view
    public void FourBind(mViewHodlerFour holder, int position) {
        bean = mList.get(position);
        holder.mPinLun.setText(this.bean.getDing() + "");
        holder.mZan.setText(this.bean.getTchild() + "");
        holder.mAddress.setText(this.bean.getMapName() + "");
        holder.mBody.setText(this.bean.getTitle() + "");
        holder.mLevel.setText("lv." + this.bean.getLevel() + "");
        holder.mName.setText(this.bean.getNick() + "");
        holder.mTime.setText(this.bean.getLastTime() + "");
        final ImageView img = holder.mTouXiang;

        Glide.with(context).load(this.bean.getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                img.setImageDrawable(ciDrawable);
            }
        });

        if (this.bean.getReplyJson1() != null) {
            holder.mTextPinLunName.setText(this.bean.getReplyJson1().getNick() + " : ");
            holder.mTextPinLun.setText(this.bean.getReplyJson1().getContent() + "");
        } else {
            holder.mTextPinLun.setVisibility(View.GONE);
            holder.mTextPinLunName.setVisibility(View.GONE);
        }
        String[] split = mList.get(position).getImage().split("\\|");

        if (split.length != 0) {
            Glide.with(context).load(split[0]).into(holder.HodlerImage1);
            Glide.with(context).load(split[1]).into(holder.HodlerImage2);
            Glide.with(context).load(split[2]).into(holder.HodlerImage3);
            Glide.with(context).load(split[3]).into(holder.HodlerImage4);
        }

    }

    // TODO: 2017/6/27   //第五个bind 子view
    public void FiveBind(mViewHodlerFive holder, int position) {
        bean = mList.get(position);
        holder.mPinLun.setText(this.bean.getDing() + "");
        holder.mZan.setText(this.bean.getTchild() + "");
        holder.mAddress.setText(this.bean.getMapName() + "");
        holder.mBody.setText(this.bean.getTitle() + "");
        holder.mLevel.setText("lv." + this.bean.getLevel() + "");
        holder.mName.setText(this.bean.getNick() + "");
        holder.mTime.setText(this.bean.getLastTime() + "");
        final ImageView img = holder.mTouXiang;
        Glide.with(context).load(this.bean.getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                img.setImageDrawable(ciDrawable);
            }
        });

        if (this.bean.getReplyJson1() != null) {
            holder.mTextPinLunName.setText(this.bean.getReplyJson1().getNick() + " : ");
            holder.mTextPinLun.setText(this.bean.getReplyJson1().getContent() + "");
        } else {
            holder.mTextPinLun.setVisibility(View.GONE);
            holder.mTextPinLunName.setVisibility(View.GONE);
        }
        String[] split = mList.get(position).getImage().split("\\|");


        if (split.length != 0) {
            Glide.with(context).load(split[0]).into(holder.HodlerImage1);
            Glide.with(context).load(split[1]).into(holder.HodlerImage2);
            Glide.with(context).load(split[2]).into(holder.HodlerImage3);
            Glide.with(context).load(split[3]).into(holder.HodlerImage4);
            Glide.with(context).load(split[4]).into(holder.HodlerImage5);

            if (split.length == 6) {
                Glide.with(context).load(split[0]).into(holder.HodlerImage1);
                Glide.with(context).load(split[1]).into(holder.HodlerImage2);
                Glide.with(context).load(split[2]).into(holder.HodlerImage3);
                Glide.with(context).load(split[3]).into(holder.HodlerImage4);
                Glide.with(context).load(split[4]).into(holder.HodlerImage5);
                Glide.with(context).load(split[5]).into(holder.HodlerImage6);
            }
        }
        if (split.length == 7) {
            Glide.with(context).load(split[0]).into(holder.HodlerImage1);
            Glide.with(context).load(split[1]).into(holder.HodlerImage2);
            Glide.with(context).load(split[2]).into(holder.HodlerImage3);
            Glide.with(context).load(split[3]).into(holder.HodlerImage4);
            Glide.with(context).load(split[4]).into(holder.HodlerImage5);
            Glide.with(context).load(split[5]).into(holder.HodlerImage6);
            Glide.with(context).load(split[6]).into(holder.HodlerImage7);
        }
        if (split.length == 8) {
            Glide.with(context).load(split[0]).into(holder.HodlerImage1);
            Glide.with(context).load(split[1]).into(holder.HodlerImage2);
            Glide.with(context).load(split[2]).into(holder.HodlerImage3);
            Glide.with(context).load(split[3]).into(holder.HodlerImage4);
            Glide.with(context).load(split[4]).into(holder.HodlerImage5);
            Glide.with(context).load(split[5]).into(holder.HodlerImage6);
            Glide.with(context).load(split[6]).into(holder.HodlerImage7);
            Glide.with(context).load(split[7]).into(holder.HodlerImage8);
        }
        if (split.length == 9) {
            Glide.with(context).load(split[0]).into(holder.HodlerImage1);
            Glide.with(context).load(split[1]).into(holder.HodlerImage2);
            Glide.with(context).load(split[2]).into(holder.HodlerImage3);
            Glide.with(context).load(split[3]).into(holder.HodlerImage4);
            Glide.with(context).load(split[4]).into(holder.HodlerImage5);
            Glide.with(context).load(split[5]).into(holder.HodlerImage6);
            Glide.with(context).load(split[6]).into(holder.HodlerImage7);
            Glide.with(context).load(split[7]).into(holder.HodlerImage8);
            Glide.with(context).load(split[8]).into(holder.HodlerImage9);
        }

    }

    //每个条目的索引
    @Override
    public int getItemCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }


    //找布局中的id  第一个
    public class mViewHodlerOne extends RecyclerView.ViewHolder {
        private ImageView mHodlerImage;
        private ImageView mTouXiang, mImageView, mImageView_One, mImageView_Two, mImageView_Three, mImageView_Four, mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;
        private LinearLayout mOne, mTwo;

        public mViewHodlerOne(View v) {
            super(v);
            mHodlerImage = (ImageView) v.findViewById(R.id.recycler_item_OneImage1);
            getId(v);
            mOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageIntent(getLayoutPosition() - 2);

                }
            });

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getLayoutBean(getLayoutPosition()-2);

                }
            });
        }

        public void getId(View v) {
            mTouXiang = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_touxiang);
            mName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_name);
            mLevel = (TextView) v.findViewById(R.id.square_naonao_recycle_item_level);
            mTime = (TextView) v.findViewById(R.id.square_naonao_recycle_item_time);
            mBody = (TextView) v.findViewById(R.id.square_naonao_recycle_item_body);
            mAddress = (TextView) v.findViewById(R.id.square_naonao_recycle_item_address);
            mZan = (TextView) v.findViewById(R.id.square_naonao_recycle_item_zan);
            mPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_pinlun);
            mTextPinLunName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun_name);
            mTextPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun);
            mImageView_Three = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_three);
            mImageView_Four = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_four);
            mImageView_Five = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_five);
            mTwo = (LinearLayout) v.findViewById(R.id.square_naonao_recycle_item_img_two);
            mOne = (LinearLayout) v.findViewById(R.id.square_naonao_recycle_item_img_one);
        }
    }

    //第二个子view
    public class mViewHodlerTwo extends RecyclerView.ViewHolder {
        private ImageView HodlerImage1, HodlerImage2;
        private ImageView mTouXiang, mImageView, mImageView_One, mImageView_Two, mImageView_Three, mImageView_Four, mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;
        private LinearLayout ImageLinear;

        public mViewHodlerTwo(View v) {
            super(v);
            //id要找对！！！！
            HodlerImage1 = (ImageView) v.findViewById(R.id.recycler_item_TwoImage1);
            HodlerImage2 = (ImageView) v.findViewById(R.id.recycler_item_TwoImage2);
            getfindId(v);

            ImageLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageIntent(getLayoutPosition() - 2);

                }
            });
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getLayoutBean(getLayoutPosition() - 2);
                    Log.d("mViewHodlerFive", "getLayoutPosition() 第二 :" + getLayoutPosition());
                }
            });


        }


        public void getfindId(View v) {
            mTouXiang = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_touxiang);
            mName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_name);
            mLevel = (TextView) v.findViewById(R.id.square_naonao_recycle_item_level);
            mTime = (TextView) v.findViewById(R.id.square_naonao_recycle_item_time);
            mBody = (TextView) v.findViewById(R.id.square_naonao_recycle_item_body);
            mAddress = (TextView) v.findViewById(R.id.square_naonao_recycle_item_address);
            mZan = (TextView) v.findViewById(R.id.square_naonao_recycle_item_zan);
            mPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_pinlun);
            mTextPinLunName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun_name);
            mTextPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun);
            mImageView_Three = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_three);
            mImageView_Four = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_four);
            mImageView_Five = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_five);
            ImageLinear = (LinearLayout) v.findViewById(R.id.square_naonao_recycle_TwoLinear);

        }

    }

    //第三个子view
    public class mViewHodlerThree extends RecyclerView.ViewHolder {
        private ImageView HodlerImage1, HodlerImage2, HodlerImage3;
        private ImageView mTouXiang, mImageView, mImageView_One, mImageView_Two, mImageView_Three, mImageView_Four, mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;
        private LinearLayout threeLinear;

        public mViewHodlerThree(View v) {
            super(v);
            //id要找对！！！！
            HodlerImage1 = (ImageView) v.findViewById(R.id.recycler_item_ThreeImage1);
            HodlerImage2 = (ImageView) v.findViewById(R.id.recycler_item_ThreeImage2);
            HodlerImage3 = (ImageView) v.findViewById(R.id.recycler_item_ThreeImage3);
            threeLinear = (LinearLayout) v.findViewById(R.id.square_naonao_ThreeImageLinear);
            threeLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageIntent(getLayoutPosition() - 2);
                }
            });
            getfindId(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getLayoutBean(getLayoutPosition() - 2);
                    Log.d("mViewHodlerFive", "getLayoutPosition() 第三 :" + getLayoutPosition());
                }
            });
        }

        public void getfindId(View v) {
            mTouXiang = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_touxiang);
            mName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_name);
            mLevel = (TextView) v.findViewById(R.id.square_naonao_recycle_item_level);
            mTime = (TextView) v.findViewById(R.id.square_naonao_recycle_item_time);
            mBody = (TextView) v.findViewById(R.id.square_naonao_recycle_item_body);
            mAddress = (TextView) v.findViewById(R.id.square_naonao_recycle_item_address);
            mZan = (TextView) v.findViewById(R.id.square_naonao_recycle_item_zan);
            mPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_pinlun);
            mTextPinLunName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun_name);
            mTextPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun);
            mImageView_Three = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_three);
            mImageView_Four = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_four);
            mImageView_Five = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_five);
        }

    }

    // TODO: 2017/7/1 第四个view

    //第四个子view
    public class mViewHodlerFour extends RecyclerView.ViewHolder {
        private ImageView HodlerImage1, HodlerImage2, HodlerImage3, HodlerImage4;
        private ImageView mTouXiang, mImageView, mImageView_One, mImageView_Two, mImageView_Three, mImageView_Four, mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;
        private LinearLayout fourLinear;

        public mViewHodlerFour(View v) {
            super(v);
            //id要找对！！！！
            HodlerImage1 = (ImageView) v.findViewById(R.id.recycler_item_fourImage1);
            HodlerImage2 = (ImageView) v.findViewById(R.id.recycler_item_fourImage2);
            HodlerImage3 = (ImageView) v.findViewById(R.id.recycler_item_fourImage3);
            HodlerImage4 = (ImageView) v.findViewById(R.id.recycler_item_fourImage4);
            fourLinear = (LinearLayout) v.findViewById(R.id.square_naonao_FourLinearImage);
            fourLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageIntent(getLayoutPosition() - 2);
                }
            });

            getfindId(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getLayoutBean(getLayoutPosition() - 2);
                    Log.d("mViewHodlerFive", "getLayoutPosition() 第四 :" + getLayoutPosition());
                }
            });

        }

        public void getfindId(View v) {
            mTouXiang = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_touxiang);
            mName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_name);
            mLevel = (TextView) v.findViewById(R.id.square_naonao_recycle_item_level);
            mTime = (TextView) v.findViewById(R.id.square_naonao_recycle_item_time);
            mBody = (TextView) v.findViewById(R.id.square_naonao_recycle_item_body);
            mAddress = (TextView) v.findViewById(R.id.square_naonao_recycle_item_address);
            mZan = (TextView) v.findViewById(R.id.square_naonao_recycle_item_zan);
            mPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_pinlun);
            mTextPinLunName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun_name);
            mTextPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun);
            mImageView_Three = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_three);
            mImageView_Four = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_four);
            mImageView_Five = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_five);
        }

    }

    // TODO: 2017/7/1 第五个view
    //第五个子view
    public class mViewHodlerFive extends RecyclerView.ViewHolder {
        private ImageView HodlerImage1, HodlerImage2, HodlerImage3, HodlerImage4, HodlerImage5, HodlerImage6, HodlerImage7, HodlerImage8, HodlerImage9;
        private ImageView mTouXiang, mImageView, mImageView_One, mImageView_Two, mImageView_Three, mImageView_Four, mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;
        private LinearLayout fiveLinear;

        public mViewHodlerFive(View v) {
            super(v);
            //id要找对！！！！
            HodlerImage1 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage1);
            HodlerImage2 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage2);
            HodlerImage3 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage3);
            HodlerImage4 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage4);
            HodlerImage5 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage5);
            HodlerImage6 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage6);
            HodlerImage7 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage7);
            HodlerImage8 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage8);
            HodlerImage9 = (ImageView) v.findViewById(R.id.recycler_item_fiveImage9);
            fiveLinear = (LinearLayout) v.findViewById(R.id.square_naonao_fiveLinearImage);
            fiveLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageIntent(getLayoutPosition() - 2);
                }
            });

            getfindId(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getLayoutBean(getLayoutPosition() - 2);
                    Log.d("mViewHodlerFive", "getLayoutPosition() 第五 :" + getLayoutPosition());

                }
            });

        }

        public void getfindId(View v) {
            mTouXiang = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_touxiang);
            mName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_name);
            mLevel = (TextView) v.findViewById(R.id.square_naonao_recycle_item_level);
            mTime = (TextView) v.findViewById(R.id.square_naonao_recycle_item_time);
            mBody = (TextView) v.findViewById(R.id.square_naonao_recycle_item_body);
            mAddress = (TextView) v.findViewById(R.id.square_naonao_recycle_item_address);
            mZan = (TextView) v.findViewById(R.id.square_naonao_recycle_item_zan);
            mPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_pinlun);
            mTextPinLunName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun_name);
            mTextPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun);
            mImageView_Three = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_three);
            mImageView_Four = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_four);
            mImageView_Five = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_five);
        }

    }


    //自定义点击事件
    private List<String> splitList = new ArrayList<>();

    public interface mOnItemClickListener {
        void ItemClick(int position);
    }

    public void setNewData(List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public void ImageIntent(int position) {
        bean = mList.get(position);
        String image = bean.getImage();
        String[] split = image.split("\\|");
        splitList.clear();
        for (String s : split) {
            splitList.add(s);
        }
        Log.d("Square_NaoNao_TypeAdapt", "splitList:" + splitList.size());

        Intent in = new Intent(context, DetailImageActivity.class);
        in.putExtra("image", (Serializable) splitList);
        context.startActivity(in);

        App.activity.overridePendingTransition(R.anim.alpha_enter, R.anim.alpha_exit);

    }

    //点击每个view传值
    private void getLayoutBean(int position) {
        Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean layBean = mList.get(position);
        Intent intent = new Intent(context, SquareNaonaoDetailActivity.class);
        String title = layBean.getTitle();
        String name = layBean.getNick();
        String time = layBean.getLastTime();
        String image = layBean.getUserFace();
        String address = layBean.getMapName();
        String Images = layBean.getImage();
        int id = layBean.getId();
        String userName = layBean.getUserName();
        SquareDetailBean detailBean = new SquareDetailBean(title, name, time, image, address, Images, id, userName);
        EventBus.getDefault().postSticky(detailBean);
        context.startActivity(intent);
    }


}
