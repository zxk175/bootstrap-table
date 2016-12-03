package com.zxk175.table.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.zxk175.table.pojo.User;
import com.zxk175.table.pojo.UserExample.Criteria;
import com.zxk175.table.pojo.UserExample.Criterion;
import com.zxk175.table.pojo.UserExample;
import java.util.List;
import java.util.Map;

public class UserSqlProvider {

    public String countByExample(UserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_user");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(UserExample example) {
        BEGIN();
        DELETE_FROM("t_user");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("t_user");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPhone() != null) {
            VALUES("user_phone", "#{userPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEmail() != null) {
            VALUES("user_email", "#{userEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPwd() != null) {
            VALUES("user_pwd", "#{userPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            VALUES("user_sex", "#{userSex,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDelete() != null) {
            VALUES("is_delete", "#{isDelete,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    public String selectByExample(UserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("user_name");
        SELECT("user_phone");
        SELECT("user_email");
        SELECT("user_pwd");
        SELECT("user_sex");
        SELECT("create_time");
        SELECT("modify_time");
        SELECT("is_delete");
        FROM("t_user");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_user");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPhone() != null) {
            SET("user_phone = #{record.userPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEmail() != null) {
            SET("user_email = #{record.userEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPwd() != null) {
            SET("user_pwd = #{record.userPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            SET("user_sex = #{record.userSex,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDelete() != null) {
            SET("is_delete = #{record.isDelete,jdbcType=TINYINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_user");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("user_phone = #{record.userPhone,jdbcType=VARCHAR}");
        SET("user_email = #{record.userEmail,jdbcType=VARCHAR}");
        SET("user_pwd = #{record.userPwd,jdbcType=VARCHAR}");
        SET("user_sex = #{record.userSex,jdbcType=TINYINT}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        SET("is_delete = #{record.isDelete,jdbcType=TINYINT}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("t_user");
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPhone() != null) {
            SET("user_phone = #{userPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEmail() != null) {
            SET("user_email = #{userEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPwd() != null) {
            SET("user_pwd = #{userPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            SET("user_sex = #{userSex,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDelete() != null) {
            SET("is_delete = #{isDelete,jdbcType=TINYINT}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(UserExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}