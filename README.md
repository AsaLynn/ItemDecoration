# MyItemDecoration
RecyclerView列表使用分割线.

# 效果图
## 横向分割线
![Image text](https://github.com/zhang721688/MyItemDecoration/blob/master/img/common.png)


## 纵向分割线
![Image text](https://github.com/zhang721688/MyItemDecoration/blob/master/img/vertical.png)


## 格子列表分割线
![Image text](https://github.com/zhang721688/MyItemDecoration/blob/master/img/grid.png)


# 添加依赖
版本1.0.0
```
//修复bug.
implementation 'com.zxn.divider:dividerlibrary:1.1.6'
implementation 'com.zxn.divider:dividerlibrary:1.1.3'
implementation 'com.zxn.divider:dividerlibrary:1.0.8'
```

# 简单方式
## 1横线
```
rv.addItemDecoration(new ItemDivider.Builder(this)
        .bgColor(R.color.colorPrimaryDark)
        .widthDp(20)
        .createCommon());
```

## 2竖线
```
rv.addItemDecoration(new ItemDivider.Builder(this)
	.showLastDiveder(false)
	.bgColor(R.color.colorPrimary)
	.createVertical());
```

## 3纵横交叉内外全部均匀分割,支持列数(x)
```
ItemDivider divider = new ItemDivider.Builder(this)
    .bgColor(R.color.c_ffffff)
    .spanCount(layoutManager.getSpanCount())
    .widthDp(5)
    .createGrid();
```


## 4纵横交叉内部均匀分割,支持列数(1,2,3,4,)
```
GridLayoutManager manager = new GridLayoutManager(mContext, 4);
rv.setLayoutManager(manager);
rv.setHasFixedSize(true);
rv.addItemDecoration(new RvItemDecoration.Builder(mContext)
        .bgColor(R.color.c_ffffff)
        .widthDp(10f)
        .spanCount(manager.getSpanCount())
        .createCenterGrid());
```