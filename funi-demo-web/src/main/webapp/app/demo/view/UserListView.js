Ext.define('app.demo.view.UserListView', {
    extend: 'Ext.grid.Panel',
    xtype: 'userList',

    requires: [
        'app.demo.model.UserModel',
        'app.demo.store.UserStore'
    ],

    title: 'User',
    initComponent: function () {
        var me = this;
        var store = Ext.create('app.demo.store.UserStore');
        store.load();
        Ext.apply(this, {
            store: store,
            columns: [
                {text: 'id', dataIndex: 'id', flex: 1},
                {text: 'name', dataIndex: 'name', flex: 1},
                {text: 'remark', dataIndex: 'remark', flex: 1}
            ]
        })
        this.callParent(arguments);
    }
});