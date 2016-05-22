package test.yuanote;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuanote.domain.Notebook;
import com.yuanote.mapper.NotebookMapper;
import com.yuanote.service.INotebookService;
import com.yuanote.service.IUserService;

public class TestNotebook {
	//FIXME 无法运行 
//	private NotebookMapper notebookMapper;
	private INotebookService notebookService;
	
	@Before
    public void before(){                                                                    
     
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"
                ,"classpath:applicationContext-servlet.xml"});
//        notebookMapper = (NotebookMapper) context.getBean("NotebookMapper");
        notebookService = (INotebookService) context.getBean("NotebookServiceImpl");
    }
	
	@Test
	public void testNotebook(){
		Notebook record = new Notebook();
		record.setNotebookName("mybook");
//		this.notebookMapper.insert(record);
		this.notebookService.createNotebook(record);
	}
}
