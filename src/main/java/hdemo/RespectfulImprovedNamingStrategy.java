package hdemo;

import org.hibernate.cfg.ImprovedNamingStrategy;

@SuppressWarnings("serial")
public class RespectfulImprovedNamingStrategy extends ImprovedNamingStrategy {
	@Override
    public String columnName(String columnName)
    {
        return columnName;
    }

    @Override
    public String tableName(String tableName)
    {
        return tableName;
    }
}