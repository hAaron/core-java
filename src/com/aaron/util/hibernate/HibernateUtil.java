package com.aaron.util.hibernate;

import java.util.List;

/**
 * 暂时不放开，缺少jar包
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.util.hibernate
 */
public class HibernateUtil {
	
//	private static SessionFactory sessionFactory = null;
//	//使用局部线程模式
//	private static ThreadLocal<Session> threadLocal = new Thr<!-- <Session> -->Session>();
//	private HibernateUtil() {};
//	static {
//		//创建SessionFactory会话工厂
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//	}
//	//获得全新的session
//	public static Session openSession() {
//		return sessionFactory.openSession();
//	}
//	//获取和线程关联的session
//	public static Session getCurrentSession() {
//		Session session = threadLocal.get();
//		if(session == null) {
//			session = sessionFactory.openSession();
//			//把sessioon对象设置到threadLocal，相当于该session已经和线程绑定
//			threadLocal.set(session);
//		}
//		return session;
//	}
//	//关闭session
//	public static void closeCurrentSession() {
//		Session session = getCurrentSession();
//		if(session != null && session.isOpen()) {
//			session.close();
//			threadLocal.set(null);
//		}
//	}
//	
//	//这里提供一个根据id返回对象的方法
//	public static Object findById(Class clazz, java.io.Serializable id) {
//		Session session = null;
//		Transaction tran = null;
//		Object obj = null;
//		try {
//			session = openSession();
//			tran = session.beginTransaction();
//			//session.load(User.class,id)
//			obj = session.load(clazz, id);
//			tran.commit();
//		}catch(Exception e) {
//			if(tran != null) {
//				tran.rollback();
//			}
//			e.printStackTrace();
//			throw new RuntimeException(e.getMessage()); 
//		}finally {
//			if(session != null && session .isOpen()) {
//				session.close();
//			}
//			
//		}
//		return obj;
//	}
//	
//	
//	//统一的一个修改和删除（批量hql）hql delete update。。。。
//	public static void executeUpdate(String hql, String [] parameters) {
//		Session session = null; 
//		Transaction tran = null; 
//		try {
//			session = openSession();
//			tran = session.beginTransaction();
//			
//			Query query = session.createQuery(hql);
//			//先判断是否有参数要绑定
//			if(parameters != null && parameters.length>0) {
//				for(int i=0; i<parameters.length; i++) {
//					query.setString(i, parameters[i]);
//				}
//			}
//			query.executeUpdate();
//			tran.commit();
//		}catch(Exception e) {
//			if(tran != null) {
//				tran.rollback();
//			}
//			e.printStackTrace();
//			throw new RuntimeException(e.getMessage()); 
//		}finally {
//			if(session != null && session .isOpen()) {
//				session.close();
//			}
//			
//		}
//	}
//	
//	//如果要配置openSessionInview
//	//统一的修改和删除
//	public static void executeUpdateOpenInview(String hql, String [] parameters) {
//		Session session = openSession();
//		Query query = session.createQuery(hql);
//		//先判断是否有参数要绑定
//		if(parameters != null && parameters.length>0) {
//			for(int i=0; i<parameters.length; i++) {
//				query.setString(i, parameters[i]);
//			}
//		}
//		query.executeUpdate();
//	}
//	
//	//统一的添加方法
//	public static void save(Object obj) {
//		Session session = null;
//		Transaction tran = null;
//		
//		try {
//			session = openSession();
//			tran = session.beginTransaction();
//			
//			session.save(obj);
//			tran.commit();
//		}catch(Exception e) {
//			if(tran != null) {
//				tran.rollback();
//			}
//			e.printStackTrace();
//			throw new RuntimeException(e.getMessage()); 
//		}finally {
//			if(session != null && session .isOpen()) {
//				session.close();
//			}
//			
//		}
//	}
//	
//	//提供一个统一的查询方法（带分页）hql 形式 from 类 where 条件=？
//	public static List executeQueryByPage(String hql, String[] parameters, int pageSize,int pageNow) {
//		Session session = null;
//		Transaction tran = null;
//		List list = null;
//		
//		try {
//			session = openSession();
//			tran = session.beginTransaction();
//			Query query = session.createQuery(hql);
//			//先判断是否有参数要绑定
//			if(parameters != null && parameters.length>0) {
//				for(int i=0; i<parameters.length; i++) {
//					query.setString(i, parameters[i]);
//				}
//			}
//			list = query.list();
//			tran.commit();
//		}catch(Exception e) {
//			if(tran != null) {
//				tran.rollback();
//			}
//			e.printStackTrace();
//			throw new RuntimeException(e.getMessage()); 
//		}finally {
//			if(session != null && session .isOpen()) {
//				session.close();
//			}
//			
//		}
//		
//		return list;
//	}

}











