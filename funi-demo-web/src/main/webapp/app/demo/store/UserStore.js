Ext.define('app.demo.store.UserStore',{
    extend:'Ext.data.Store',
    alias: 'store.UserStore',
    requires:'app.demo.model.UserModel',
    model:'app.demo.model.UserModel',
    pageSize:10,
    proxy:{
        actionMethods:'post',
        type:'ajax',
        api:{
            read:'/demo/user/list'
        },
        reader:{
            type:'json',
            rootProperty:'result.list',
            totalProperty: 'result.total'
        }
    }
});