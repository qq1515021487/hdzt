package com.bnuz.commons.baseController;

import com.bnuz.commons.baseService.BaseService;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * Created by QuanQqqqq on 2018/4/2.
 */

public abstract class BaseController<T, ID extends Serializable> {
    /**
     * 抽象业务类  T 实体对象   ID为
     * @return
     */
    public abstract BaseService<T,ID> getService();

    @RequestMapping(value = "/findOneByID",method = RequestMethod.GET)
    @ApiOperation("单个查找")
    @ResponseBody
    public Result findOne(ID id){
        return Result.success(getService().findOne(id));
    }

    @ApiOperation("单个添加")
    @ResponseBody
    @RequestMapping(value = "/addOne",method = RequestMethod.POST)
    public Result addOne(T t) {
        getService().addOne(t);
        return Result.success(null);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/deleteByID",method = RequestMethod.DELETE)
    @ApiOperation("根据ID删除")
    @ResponseBody
    public Result deleteByID(ID id) {
        try {
            getService().deleteByID(id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail("删除失败", ErrorCode.BAD_REQUEST);
        }
    }

    /**
     * 更新
     * @param t
     * @param objectID
     */
    @RequestMapping(value = "/updateByID",method = RequestMethod.PUT)
    @ApiOperation("更新实体")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(value = "对象的主键ID", name = "objectID", required = true)
    })
    public Result updateByID(T t, ID objectID) {
        System.out.println(objectID);
        T pt = getService().findOne(objectID);
        if (getService().findOne(objectID) == null) {
            return Result.fail("无法通过ID更新", ErrorCode.BAD_REQUEST);
        }
        getService().update(t);
        return  Result.success(null);
    }

    /**
     * 查找所有
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation("查询所有")
    @ResponseBody
    public Result findAll() {
         return Result.success(getService().findAll());
    }


//    protected Predicate toPredicate(T t, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//        List<Predicate> predicates = new ArrayList<>();
//        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
//
//    }
//
//    /**
//     * 分页实现
//     * @param t 查找的对象
//     * @param pageable 分页条件
//     * @return
//     */
//    @Override
//    public Page<T> findByPage(final T t, Pageable pageable) {
//        return getRepository().findAll(new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                return BaseServiceImpl.this.toPredicate(t,root,criteriaQuery,criteriaBuilder);
//            }
//        }, pageable);
//    }


}
