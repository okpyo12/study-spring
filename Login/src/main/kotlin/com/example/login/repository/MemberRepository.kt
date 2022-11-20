package com.example.login.repository

import com.example.login.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MemberRepository: JpaRepository<Member, Long> {
    @Query("select m from Member m where m.email = ?1")
    fun findByEmail(email:String): Member?
}