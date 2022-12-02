package com.spring.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.spring.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;


@Repository
public class BoardDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;




	public int insertBoard(BoardVO vo) {
		String sql="insert into BOARD (title, writer, content) values ("
				+ "'"+ vo.getTitle() +"',"
				+"'"+ vo.getWriter() + "',"
				+"'"+ vo.getContent() + "',"
				+"'"+ vo.getCategory() + "')";
		return jdbcTemplate.update(sql);
	}
	public int deleteBoard(int seq) {
		String sql="delete from BOARD  where seq= " + seq;
		return jdbcTemplate.update(sql);
	}
	// 글 삭제

	public int updateBoard(BoardVO vo) {
		String sql= "update BOARD set'"				// 혹시 모르니까 나중에 수정
				+ "title='" +vo.getTitle() +"',"
				+ "writer='" +vo.getWriter() +"',"
				+ "content='" +vo.getContent() +"',"
				+ "category='" +vo.getCategory() +"' where seq=" +vo.getSeq();
		return jdbcTemplate.update(sql);
	}	
	
	public BoardVO getBoard(int seq) {
		String sql= "select * from BOARD  where seq=" +seq;
		return jdbcTemplate.queryForObject(sql,new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(){
		String sql ="select * from BOARD order by seq desc";
		return jdbcTemplate.query(sql,new BoardRowMapper());
	}
	class BoardRowMapper implements RowMapper<BoardVO>{
		@Override
		public BoardVO mapRow(ResultSet rs,int rowNum) throws SQLException{
			BoardVO vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setWriter(rs.getString("writer"));
			vo.setCategory(rs.getString("category"));
			vo.setRegdate(rs.getDate("regdate"));
			return vo;
		}
	}


}
