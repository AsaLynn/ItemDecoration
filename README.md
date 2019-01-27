# MyItemDecoration
RecyclerView列表使用分割线.

# 效果图
## 横向分割线
![Image text](https://github.com/zhang721688/MyItemDecoration/blob/master/img/common.png)


## 纵向分割线
![Image text](https://github.com/zhang721688/MyItemDecoration/blob/master/img/grid.png)

## 格子列表分割线
![Image text](https://github.com/zhang721688/MyItemDecoration/blob/master/img/vertical.png)

# 添加依赖
版本1.0.0
```
implementation 'com.zxn.divider:dividerlibrary:1.0.0'
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

## 3纵横交叉
```
ItemDivider divider = new ItemDivider.Builder(this)
    .bgColor(R.color.c_ffffff)
    .spanCount(layoutManager.getSpanCount())
    .widthDp(5)
    .createGrid();
```
