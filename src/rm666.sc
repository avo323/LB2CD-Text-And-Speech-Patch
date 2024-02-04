;;; Sierra Script 1.0 - (do not remove this comment)
(script# 666)
(include sci.sh)
(use Main)
(use LBRoom)
(use Scaler)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm666 0
)

(local
	local0
	local1
	local2
	local3
)
(instance rm666 of LBRoom
	(properties)
	
	(method (init)
		(self setRegions: 90)
		(gEgo setScale: Scaler 100 100 0 10)
		(if (== gGNumber 520)
			(gEgo init: posn: 277 55 normalize: 732)
			(proc0_3 31)
		else
			(gEgo init: posn: 96 161 normalize: 732)
		)
		(self
			picture:
				(if ((Inv at: 15) cel?)
					(if (== gGNumber 520) 735 else 730)
				else
					780
				)
		)
		(if ((Inv at: 15) cel?)
			(Palette palSET_INTENSITY 0 255 0)
		)
		(gGame handsOff:)
		(super init:)
		(if ((Inv at: 15) cel?)
			(WrapMusic pause: 0)
			(= local0 1)
			(if (== gGNumber 520)
				(self setScript: sEnterSouthLight520)
			else
				(self setScript: sEnterSouthLight)
			)
		else
			(gGameMusic2 number: 56 flags: 1 loop: -1 play:)
			(gEgo hide:)
			(proc958_0 132 82 53)
			(self setScript: sEnterDark)
		)
	)
	
	(method (doit)
		(super doit: &rest)
		(if
		(and (== (self picture?) 780) ((Inv at: 15) cel?))
			(gGame handsOff:)
			(gGameMusic2 fade:)
			(WrapMusic pause: 0)
			(= local0 1)
			(Palette palSET_INTENSITY 0 255 0)
			(if (== gGNumber 520)
				(self picture: 735 drawPic: 735)
			else
				(self picture: 730 drawPic: 730)
			)
			(if (== gGNumber 520)
				(gEgo
					view: 732
					setLoop: 5
					posn: 277 55
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setCycle: Walk
					show:
				)
			else
				(gEgo
					view: 732
					setLoop: 0
					posn: 96 161
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setCycle: Walk
					show:
				)
			)
			(= local3 1)
		)
		(if local0
			(Palette palSET_INTENSITY 0 255 (= local2 (+ local2 2)))
			(if (>= local2 100)
				(= local0 0)
				(if local3
					(if (== gGNumber 520)
						(self setScript: sEnterSouthLight520)
					else
						(self setScript: sEnterSouthLight)
					)
				)
			)
		)
		(if local1
			(Palette
				palSET_INTENSITY
				0
				255
				(proc999_3 0 (= local2 (- local2 3)))
			)
			(if (== local2 0) (= local1 0))
		)
	)
	
	(method (dispose)
		(WrapMusic pause: 1)
		(gGameMusic2 fade:)
		(super dispose: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(cond 
			((== newRoomNumber 99) 0)
			((== gGNumber 650)
				(if
					(and
						(== global123 3)
						(proc0_10 -15612 1)
						(not (proc0_10 -15612))
					)
					(= newRoomNumber 565)
				else
					(= newRoomNumber 560)
				)
			)
			((== gGNumber 630) (= newRoomNumber 454))
			((== gGNumber 520) (= newRoomNumber 610))
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sEnterSouthLight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(= cycles 1)
				else
					(gEgo
						setLoop: 0
						posn: -10 240
						edgeHit: 0
						setCycle: Walk
						cycleSpeed: 4
						moveSpeed: 4
						xStep: 2
						setMotion: MoveTo 96 161 self
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 277 55 self)
			)
			(2
				(= local1 1)
				(gEgo setMotion: MoveTo 335 23 self)
			)
			(3
				(global2 drawPic: 780)
				(global2 newRoom: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEnterSouthLight520 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(= cycles 1)
				else
					(gEgo
						setLoop: 5
						posn: 335 23
						edgeHit: 0
						setCycle: Walk
						cycleSpeed: 4
						moveSpeed: 4
						xStep: 2
						setMotion: MoveTo 277 55 self
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 96 161 self)
			)
			(2
				(= local1 1)
				(gEgo setMotion: MoveTo -10 240 self)
			)
			(3
				(global2 drawPic: 780)
				(global2 newRoom: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEnterDark of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 15)
					(gGame handsOn:)
					(User canControl: 0)
					(User canInput: 0)
					(gIconBar disable: 0 1 2 3 4 5 7)
					(= seconds 8)
				else
					(gIconBar disable: 6)
					(= seconds 4)
				)
			)
			(1
				(sFX2 number: 53 loop: -1 flags: 1 play:)
				(= ticks 120)
			)
			(2
				(sFX number: 82 loop: 1 flags: 1 play: self)
			)
			(3 (sFX2 fade: self))
			(4
				(= global145 15)
				(global2 newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		flags $0001
	)
)

(instance sFX2 of Sound
	(properties
		flags $0001
	)
)
