package myapp.com.mjj.listviewitemtype;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private List<String> contents;
    private Context context;

    public ListAdapter(List<String> contents, Context context) {
        this.contents = contents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object getItem(int position) {
        return contents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            int type = getItemViewType(position);
            //位置为偶数的就让内容显示在右边，奇数就显示在左边
            switch (type) {
                case 0:
                    convertView = View.inflate(context, R.layout.item_right, null);
                    break;
                case 1:
                    convertView = View.inflate(context, R.layout.item_left, null);
                    break;
            }
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            holder.textView = (TextView) convertView.findViewById(R.id.text_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(contents.get(position));
        return convertView;
    }

    //返回布局的种类个数
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    //返回布局的类型
    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
