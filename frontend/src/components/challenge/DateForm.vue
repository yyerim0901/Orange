<template>
    <v-row>
      <v-col>
        <v-dialog
          ref="dialog"
          v-model="modal"
          :return-value.sync="date"
          persistent
          width="290px"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="dateRangeText"
              hint="클릭해서 날짜를 선택해 주세요."
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              label="챌린지 기간"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="dates"
            scrollable
            range
          >
            <v-spacer></v-spacer>
            <v-btn
              text
              color="primary"
              @click="modal = false"
            >
              Cancel
            </v-btn>
            <v-btn
              text
              color="primary"
              @click="$refs.dialog.save(date)"
            >
              OK
            </v-btn>
          </v-date-picker>
        </v-dialog>
      </v-col>
      <v-spacer></v-spacer>
    </v-row>
    
</template>

<script>
  export default {
    name: 'DateForm',
    data: () => ({
      dates: [],
      modal: false,
      date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
    }),
    computed: {
      dateRangeText () {
        return this.dates.join(' ~ ')
      },
    },
  }
</script>