Ext.define('app.demo.model.UserModel', {
    extend: 'Ext.data.Model',
    alias: 'model.UserModel',
    idProperty: 'id',
    fields: [
        {name: 'id',mapping: 'id',  type: 'string'},
        {name: 'name',mapping: 'name',  type: 'string'},
        {name: 'password',mapping: 'password',  type: 'string'},
        {name: 'lastLoginDate',mapping: 'lastLoginDate',  type: 'date',dateFormat:'Y-m-d H:i:s'},
        {name: 'lastLoginIp',mapping: 'lastLoginIp',  type: 'string'},
        {name: 'remark',mapping: 'remark',  type: 'string'},
        {name: 'isDeleted',mapping: 'isDeleted',  type: 'boolean'},
        {name: 'version',mapping: 'version',  type: 'int'},
        {name: 'sysCreateTime',mapping: 'sysCreateTime',  type: 'date',dateFormat:'Y-m-d H:i:s'},
        {name: 'sysUpdateTime',mapping: 'sysUpdateTime',  type: 'date',dateFormat:'Y-m-d H:i:s'},
        {name: 'sysDeleteTime',mapping: 'sysDeleteTime',  type: 'date',dateFormat:'Y-m-d H:i:s'},
        {name: 'sysCreateId',mapping: 'sysCreateId',  type: 'string'},
        {name: 'sysUpdateId',mapping: 'sysUpdateId',  type: 'string'},
        {name: 'sysDeleteId',mapping: 'sysDeleteId',  type: 'string'},
    ]
});