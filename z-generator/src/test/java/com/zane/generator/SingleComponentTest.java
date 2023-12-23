package com.zane.generator;

import com.zane.generator.domain.GenTable;
import com.zane.generator.mapper.GenTableColumnMapper;
import com.zane.generator.mapper.GenTableMapper;
import com.zane.generator.service.GenTableServiceImpl;
import com.zane.generator.service.IGenTableService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import javax.annotation.Resource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SingleComponentTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public IGenTableService employeeService() {
            return new GenTableServiceImpl();
        }
    }

    @MockBean
    private GenTableMapper genTableMapper;
    @MockBean
    private GenTableColumnMapper genTableColumnMapper;

    @Resource
    private IGenTableService genTableService;

    private String tableName = "sys_dept";

    @Before
    public void setUp() {
        GenTable table = new GenTable();
        table.setTableName(tableName);
        Mockito.when(genTableMapper.selectGenTableByName(tableName))
                .thenReturn(table);
    }

    @Test
    public void test1() {
        genTableService.generatorCode(tableName);
    }
}
