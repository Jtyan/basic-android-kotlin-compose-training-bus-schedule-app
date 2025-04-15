package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/*
Room sees the interface, then generates a class at compile-time that implements it.
You don’t need to write the implementation yourself — that’s the magic.
If you made it a class, you'd have to implement every function manually (which defeats the purpose).
 */
@Dao
interface ScheduleDAO {

    @Query("SELECT * FROM schedule ORDER BY arrivalTimeInMillis ASC")
    fun getAllItems(): Flow<List<BusSchedule>>

    @Query("SELECT * FROM schedule WHERE id = :id")
    fun getItem(id: Int): Flow<BusSchedule>
}