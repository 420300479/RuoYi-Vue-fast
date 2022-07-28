<template>
    <div class="row">
    <div class="col-xs-12 form-inline">
        <div class="form-group">
            <label for="filter" class="sr-only">Filter</label>
            <input type="text" class="form-control" v-model="filter" placeholder="Filter">
        </div>
    </div>
</div>

<div class="row">
    <div id="table" class="col-xs-12 table-responsive">
        <datatable :columns="columns" :data="rows" :filter-by="filter"></datatable>
    </div>
</div>

<div class="row">
    <div class="col-xs-12 form-inline">
        <datatable-pager v-model="page" type="abbreviated" :per-page="per_page"></datatable-pager>
    </div>
</div>

<hr>

<div class="row">
    <div class="col-xs-12 form-inline">
        <div class="form-group">
            <label for="filter2" class="sr-only">Filter</label>
            <input type="text" class="form-control" v-model="filter2" placeholder="Filter">
        </div>
    </div>
</div>

<div class="row">
    <div id="table" class="col-xs-12 table-responsive">
        <datatable :columns="columns" :data="rows" :filter-by="filter2" name="table-2"></datatable>
    </div>
</div>

<div class="row">
    <div class="col-xs-12 form-inline">
        <datatable-pager v-model="page2" type="abbreviated" :per-page="per_page2" table="table-2"></datatable-pager>
    </div>
</div>
</template>

<script> 

new Vue({
    el: '#table',
    data: {
        filter: '',
        filter2: '',
        columns: [
            { label: 'ID', field: 'id', align: 'center', filterable: false },
            { label: 'Username', field: 'user.username' },
            { label: 'First Name', field: 'user.first_name' },
            { label: 'Last Name', field: 'user.last_name' },
            { label: 'Email', field: 'user.email', align: 'right', sortable: false },
            {label: 'Address', representedAs: function (row) {
                    return row.address + ', ' + row.city + ', ' + row.state;
                }, align: 'right', sortable: false
            }
        ],
        rows: window.rows,
        page: 1,
        per_page: 10,
        page2: 1,
        per_page2: 10,
    }
});
</script>