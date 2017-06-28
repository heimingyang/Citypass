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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.naonao.detail.SquareDetailBean;
import com.example.citypass.cotroller.fragment.naonao.detail.SquareNaonaoDetailActivity;
import com.example.citypass.model.bean.naonao.Recommond_NaoNao_Bean;

import org.greenrobot.eventbus.EventBus;

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

public class Recommond_NaoNao_TypeAdapter extends RecyclerView.Adapter {
    private List<Recommond_NaoNao_Bean.ServerInfoBean> mList;
    private View view;
    private Context context;
    private Recommond_NaoNao_Bean.ServerInfoBean bean;
    private mOnItemClickListener onItemClickListener;
    private int onePosition, twoPostion, ThreePostion, FourPosition, FivePosition;

    public void setOnItemClickListener(mOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public Recommond_NaoNao_TypeAdapter(List<Recommond_NaoNao_Bean.ServerInfoBean> mList, Context context) {
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

    //处理业务逻辑
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                mViewHodlerOne one = (mViewHodlerOne) holder;
                onePosition = position;
                oneBind(one, onePosition);

                break;
            case 1:
                mViewHodlerOne one1 = (mViewHodlerOne) holder;

                onePosition = position;
                oneBind(one1, onePosition);

                break;
            case 2:
                mViewHodlerTwo two = (mViewHodlerTwo) holder;
                twoPostion = position;
                twoBind(two, twoPostion);

                break;
            case 3:
                mViewHodlerThree three = (mViewHodlerThree) holder;
                ThreePostion = position;
                threeBind(three, ThreePostion);
                break;
            case 4:
                mViewHodlerFour four = (mViewHodlerFour) holder;
                FourPosition = position;
                FourBind(four, FourPosition);
                break;
            case 5:
                mViewHodlerFive five = (mViewHodlerFive) holder;
                FivePosition = position;

                FiveBind(five, FivePosition);
                break;

        }


    }


    // TODO: 2017/6/27 第一个子view
    private void oneBind(mViewHodlerOne holder, int position) {
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
        if (bean.getImage() == null) {
            holder.mOne.setVisibility(View.GONE);
            holder.mHodlerImage.setVisibility(View.GONE);
        } else {
            holder.mOne.setVisibility(View.VISIBLE);
            holder.mHodlerImage.setVisibility(View.VISIBLE);
            Glide.with(context).load(this.bean.getImage()).into(holder.mHodlerImage);
        }

    }

    // TODO: 2017/6/27   //第二个子view
    public void twoBind(mViewHodlerTwo holder, int position) {
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
        Log.d("Square_NaoNao_TypeAdapt", "split:" + split);
        Log.d("Square_NaoNao_TypeAdapt", "第一个" + split[0]);
        Log.d("Square_NaoNao_TypeAdapt", split[1]);
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
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Recommond_NaoNao_Bean.ServerInfoBean oneBean = mList.get(onePosition);
                    Intent intent = new Intent(context, SquareNaonaoDetailActivity.class);
                    String title = oneBean.getTitle();
                    String name = oneBean.getNick();
                    String time = oneBean.getLastTime();
                    String image = oneBean.getUserFace();
                    String address = oneBean.getMapName();
                    String Images = oneBean.getImage();
                    SquareDetailBean detailBean = new SquareDetailBean(title, name, time, image, address, Images);
                    EventBus.getDefault().postSticky(detailBean);
                    context.startActivity(intent);
                    Toast.makeText(context, "onePosition:" + onePosition, Toast.LENGTH_SHORT).show();
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

        public mViewHodlerTwo(View v) {
            super(v);
            //id要找对！！！！
            HodlerImage1 = (ImageView) v.findViewById(R.id.recycler_item_TwoImage1);
            HodlerImage2 = (ImageView) v.findViewById(R.id.recycler_item_TwoImage2);
            getfindId(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Recommond_NaoNao_Bean.ServerInfoBean twoBean = mList.get(twoPostion);
                    Toast.makeText(context, "twoPostion:" + twoPostion, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, SquareNaonaoDetailActivity.class);
                    String title = twoBean.getTitle();
                    String name = twoBean.getNick();
                    String time = twoBean.getLastTime();
                    String image = twoBean.getUserFace();
                    String address = twoBean.getMapName();
                    String Images = twoBean.getImage();
                    SquareDetailBean detailBean = new SquareDetailBean(title, name, time, image, address, Images);
                    EventBus.getDefault().postSticky(detailBean);
                    context.startActivity(intent);

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

    //第三个子view
    public class mViewHodlerThree extends RecyclerView.ViewHolder {
        private ImageView HodlerImage1, HodlerImage2, HodlerImage3;
        private ImageView mTouXiang, mImageView, mImageView_One, mImageView_Two, mImageView_Three, mImageView_Four, mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;

        public mViewHodlerThree(View v) {
            super(v);
            //id要找对！！！！
            HodlerImage1 = (ImageView) v.findViewById(R.id.recycler_item_ThreeImage1);
            HodlerImage2 = (ImageView) v.findViewById(R.id.recycler_item_ThreeImage2);
            HodlerImage3 = (ImageView) v.findViewById(R.id.recycler_item_ThreeImage3);
            getfindId(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Recommond_NaoNao_Bean.ServerInfoBean mBean = mList.get(ThreePostion);
                    Toast.makeText(context, "ThreePostion:" + ThreePostion, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, SquareNaonaoDetailActivity.class);
                    String title = bean.getTitle();
                    String name = bean.getNick();
                    String time = bean.getLastTime();
                    String image = bean.getUserFace();
                    String address = bean.getMapName();
                    String Images = bean.getImage();
                    SquareDetailBean detailBean = new SquareDetailBean(title, name, time, image, address, Images);
                    EventBus.getDefault().postSticky(detailBean);
                    context.startActivity(intent);
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

    //第四个子view
    public class mViewHodlerFour extends RecyclerView.ViewHolder {
        private ImageView HodlerImage1, HodlerImage2, HodlerImage3, HodlerImage4;
        private ImageView mTouXiang, mImageView, mImageView_One, mImageView_Two, mImageView_Three, mImageView_Four, mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;

        public mViewHodlerFour(View v) {
            super(v);
            //id要找对！！！！
            HodlerImage1 = (ImageView) v.findViewById(R.id.recycler_item_fourImage1);
            HodlerImage2 = (ImageView) v.findViewById(R.id.recycler_item_fourImage2);
            HodlerImage3 = (ImageView) v.findViewById(R.id.recycler_item_fourImage3);
            HodlerImage4 = (ImageView) v.findViewById(R.id.recycler_item_fourImage4);
            getfindId(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Recommond_NaoNao_Bean.ServerInfoBean mBean = mList.get(FourPosition);
                    Toast.makeText(context, "FourPosition:" + FourPosition, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, SquareNaonaoDetailActivity.class);
                    String title = mBean.getTitle();
                    String name = mBean.getNick();
                    String time = mBean.getLastTime();
                    String image = mBean.getUserFace();
                    String address = mBean.getMapName();
                    String Images = mBean.getImage();
                    SquareDetailBean detailBean = new SquareDetailBean(title, name, time, image, address, Images);
                    EventBus.getDefault().postSticky(detailBean);
                    context.startActivity(intent);
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

    //第五个子view
    public class mViewHodlerFive extends RecyclerView.ViewHolder {
        private ImageView HodlerImage1, HodlerImage2, HodlerImage3, HodlerImage4, HodlerImage5, HodlerImage6, HodlerImage7, HodlerImage8, HodlerImage9;
        private ImageView mTouXiang, mImageView, mImageView_One, mImageView_Two, mImageView_Three, mImageView_Four, mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;

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
            getfindId(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Recommond_NaoNao_Bean.ServerInfoBean mBean = mList.get(FivePosition);
                    Toast.makeText(context, "FivePosition:" + FivePosition, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, SquareNaonaoDetailActivity.class);
                    String title = mBean.getTitle();
                    String name = mBean.getNick();
                    String time = mBean.getLastTime();
                    String image = mBean.getUserFace();
                    String address = mBean.getMapName();
                    String Images = mBean.getImage();
                    SquareDetailBean detailBean = new SquareDetailBean(title, name, time, image, address, Images);
                    EventBus.getDefault().postSticky(detailBean);
                    context.startActivity(intent);
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

    public interface mOnItemClickListener {
        void ItemClick(int position);
    }


}
