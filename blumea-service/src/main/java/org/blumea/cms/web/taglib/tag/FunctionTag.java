package org.blumea.cms.web.taglib.tag;

import net.common.utils.money.MoneyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义Function类Tag
 * <p/>
 * User: zhangchao@mail-inc.com
 * Date: 12-5-28
 * Time: 下午8:05
 */
public final class FunctionTag {

    private static final Logger LOGGER = LoggerFactory.getLogger(net.common.utils.taglib.tag.FunctionTag.class);

    /**
     * 将long型的值按照precision指定的小数位数进行转换
     *
     * @param value     原始值
     * @param precision 小数位数
     * @return 转换后的值
     */
    public static String decimal(Long value, int precision) {
        Long internalValue = value;
        if (internalValue == null) {
            LOGGER.warn("value is null, set to 0");
            internalValue = 0L;
        }
        return MoneyUtil.convertToDecimal(internalValue, precision);
    }

    private FunctionTag() {
    }
}
