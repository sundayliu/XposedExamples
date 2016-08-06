package com.android.vending.billing.InAppBillingService.LACK;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterWithFilter<Object>
  extends ArrayAdapter<Object>
  implements Filterable
{
  private Context context;
  public List<Object> dataList;
  private Filter objectFilter;
  public List<Object> origDataList;
  private int resource_layout;
  
  public ArrayAdapterWithFilter(Context paramContext, int paramInt, List<Object> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.resource_layout = paramInt;
    this.dataList = paramList;
    this.context = paramContext;
    this.origDataList = paramList;
  }
  
  public int getCount()
  {
    return this.dataList.size();
  }
  
  public Filter getFilter()
  {
    if (this.objectFilter == null) {
      this.objectFilter = new ObjectFilter(null);
    }
    return this.objectFilter;
  }
  
  public Object getItem(int paramInt)
  {
    return (Object)this.dataList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.dataList.get(paramInt).hashCode();
  }
  
  public void resetData()
  {
    this.dataList = this.origDataList;
  }
  
  private class ObjectFilter
    extends Filter
  {
    private ObjectFilter() {}
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
      {
        localFilterResults.values = ArrayAdapterWithFilter.this.origDataList;
        localFilterResults.count = ArrayAdapterWithFilter.this.origDataList.size();
        return localFilterResults;
      }
      paramCharSequence = new ArrayList();
      localFilterResults.values = paramCharSequence;
      localFilterResults.count = paramCharSequence.size();
      return localFilterResults;
    }
    
    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      if (paramFilterResults.count == 0)
      {
        ArrayAdapterWithFilter.this.notifyDataSetInvalidated();
        return;
      }
      ArrayAdapterWithFilter.this.dataList = ((List)paramFilterResults.values);
      ArrayAdapterWithFilter.this.notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/ArrayAdapterWithFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */