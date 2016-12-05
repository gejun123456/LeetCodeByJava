package jpaparse.info;

/**
 * Created by bruce.ge on 2016/12/4.
 */
public class FindInfo extends BaseInfo {

    private Boolean distinct = false;

    private Boolean allField = true;

    private String fetchPart = "";


    public Integer getLastEqualLength() {
        return lastEqualLength;
    }

    public void setLastEqualLength(Integer lastEqualLength) {
        this.lastEqualLength = lastEqualLength;
    }


    public String getLastQueryProp() {
        return lastQueryProp;
    }

    public void setLastQueryProp(String lastQueryProp) {
        this.lastQueryProp = lastQueryProp;
    }

    public String getTable() {
        return table;
    }


    /**
     * Sets table. the table name to build.
     *
     * @param table the table
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * Gets param count.
     *
     * @return the param count
     */
    public Integer getParamCount() {
        return paramCount;
    }

    /**
     * Sets param count. for sql to set with {0} {1}.
     *
     * @param paramCount the param count
     */
    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }

    /**
     * Gets distinct.
     *
     * @return the distinct
     */
    public Boolean getDistinct() {
        return distinct;
    }

    /**
     * Sets distinct.
     *
     * @param distinct the distinct
     */
    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * Gets all field.
     *
     * @return the all field
     */
    public Boolean getAllField() {
        return allField;
    }

    /**
     * Sets all field.
     *
     * @param allField the all field
     */
    public void setAllField(Boolean allField) {
        this.allField = allField;
    }

    /**
     * Gets fetch part.
     *
     * @return the fetch part
     */
    public String getFetchPart() {
        return fetchPart;
    }

    /**
     * part after select and before from.
     * <p>
     * select id and username from xxx here id and username is the fetch part.
     *
     * @param fetchPart the fetch part
     */
    public void setFetchPart(String fetchPart) {
        this.fetchPart = fetchPart;
    }

    /**
     * Gets query part.
     *
     * @return the query part
     */
    public String getQueryPart() {
        return queryPart;
    }

    /**
     * Sets query part.
     * query part is the sql after where.
     *
     * @param queryPart the query part
     */
    public void setQueryPart(String queryPart) {
        this.queryPart = queryPart;
    }
}
